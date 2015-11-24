package euler.maths

import scala.collection.SortedMap
import scala.math._
import euler._

object Matrix {

  class Matrix[T](val rowCount: Int, val columnCount: Int, val data: IndexedSeq[T] = IndexedSeq.empty) {
    def isDefined = (rowCount * columnCount) == data.size

    def isNotDefined = !isDefined

    override def toString = {
      if (isNotDefined) "UndefinedMatrix"
      else {
        val newLine = "\n"
        val tabSpace = "\t"
        newLine + data.grouped(columnCount).map(tabSpace + _.mkString(tabSpace)).mkString(newLine)
      }
    }

    def get(rowIndex: Int, columnIndex: Int) = {
      require(isDefined && rowIndex <= rowCount - 1 && columnIndex <= columnCount - 1)
      data(rowIndex * columnCount + columnIndex)
    }

    def populate(dataPoints: IndexedSeq[T]) = {
      require(dataPoints.size == rowCount * columnCount)
      new Matrix(rowCount, columnCount, dataPoints)
    }

    def transpose = {
      if (isNotDefined) new Matrix[T](columnCount, rowCount)
      else {
        val dataGroupedByColumns = data.zipWithIndex.groupBy { case (datum, index) => index % columnCount }.toIndexedSeq
        val indexSortedDataGroupedByColumns = SortedMap(dataGroupedByColumns: _*).values.toIndexedSeq
        val transposedData = indexSortedDataGroupedByColumns.flatten.unzip_1
        new Matrix(columnCount, rowCount, transposedData)
      }
    }

    def getDiagonal(rowIndex: Int, columnIndex: Int): IndexedSeq[T] = {
      require(isDefined && (0 until rowCount).contains(rowIndex) && (0 until columnCount).contains(columnIndex))

      def isBoundary(positionIndex: PositionIndex) = positionIndex.rowIndex == (rowCount - 1) || positionIndex.columnIndex == (columnCount - 1)

      case class PositionIndex(rowIndex: Int, columnIndex: Int)

      def translateToPositionIndex(dataIndex: Int): PositionIndex = {
        val rowIndex = dataIndex / columnCount
        val columnIndex = dataIndex % columnCount
        PositionIndex(rowIndex, columnIndex)
      }

      def translateToDataIndex(positionIndex: PositionIndex) = positionIndex.rowIndex * columnCount + positionIndex.columnIndex

      def dataWithBoundaryIndicator = data.zipWithIndex.map {
        case (dataPoint, index) =>
          val positionIndex = translateToPositionIndex(index)
          (dataPoint, isBoundary(positionIndex))
      }

      val offset = min(rowIndex, columnIndex)
      val rowCornerIndex = rowIndex - offset
      val columnCornerIndex = columnIndex - offset
      val diagonalHeadIndex = translateToDataIndex(PositionIndex(rowCornerIndex, columnCornerIndex))

      dataWithBoundaryIndicator
        .drop(diagonalHeadIndex)
        .zipWithIndex.filter(_._2 % (columnCount + 1) == 0).unzip_1
        .takeUntil { case (_, isBoundary) => !isBoundary }.unzip_1
    }

    def getReverseDiagonal(rowIndex: Int, columnIndex: Int): IndexedSeq[T] = {
      require(isDefined && (0 until rowCount).contains(rowIndex) && (0 until columnCount).contains(columnIndex))
      mirror.getDiagonal(rowIndex, columnIndex)
    }

    def mirror = {
      if(isNotDefined) this
      else new Matrix(rowCount, columnCount, data.grouped(columnCount).flatMap(_.reverse).toIndexedSeq)
    }

    def getDiagonals = {
      require(isDefined)
      ((0 to rowCount - 1).map(getDiagonal(_, 0)) ++ (0 to columnCount - 1).map(getDiagonal(0, _))).toSet
    }

    def getReverseDiagonals = {
      require(isDefined)
      ((0 to rowCount - 1).map(getReverseDiagonal(_, columnCount - 1)) ++
        (0 to columnCount - 1).map(getReverseDiagonal(rowCount - 1, _))).toSet
    }

    def rowSliding(size: Int) = {
      require(isDefined)
      data.grouped(columnCount).filter(_.size >= size).flatMap(row => row.sliding(size))
    }

    def columnSliding(size: Int) = this.transpose.rowSliding(size)

    def diagonalSliding(size: Int) = getDiagonals.toIndexedSeq.filter(_.size >= size).flatMap(_.sliding(size))

    def reverseDiagonalSliding(size: Int) = getReverseDiagonals.toIndexedSeq.filter(_.size >= size).flatMap(_.sliding(size))
  }

  def apply(size: Int): Matrix[Any] = new Matrix[Any](size, size)

  def apply(rows: Int, columns: Int) = new Matrix[Any](rows, columns)

  def apply[T](size: Int, data: IndexedSeq[T]) = {
    require(data.size == size * size)
    new Matrix(size, size, data)
  }

  def apply[T](rows: Int, columns: Int, data: IndexedSeq[T]) = {
    require(data.size == rows * columns)
    new Matrix(rows, columns, data)
  }
}