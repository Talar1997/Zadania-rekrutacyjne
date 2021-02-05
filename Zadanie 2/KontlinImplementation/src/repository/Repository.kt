package repository

interface Repository<T> {
    fun getAll(): List<T>
}