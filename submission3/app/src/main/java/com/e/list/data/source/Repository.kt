package com.e.list.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.e.list.BuildConfig
import com.e.list.data.source.local.LocalDataSource
import com.e.list.data.source.local.entity.MovieEntity
import com.e.list.data.source.local.entity.TvShowEntity
import com.e.list.data.source.remote.RemoteDataSource
import com.e.list.data.source.remote.api.ApiResponse
import com.e.list.data.source.remote.response.MovieDetailResponse
import com.e.list.data.source.remote.response.MovieItem
import com.e.list.data.source.remote.response.TvShowDetailResponse
import com.e.list.data.source.remote.response.TvShowItem
import com.e.list.utils.AppExecutors
import com.e.list.vo.Resource

class Repository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : DataSource {
    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(
                    remoteData,
                    localData,
                    appExecutors
                ).apply { instance = this }
            }
    }

    override fun getMovieList(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieItem>>> =
                remoteDataSource.getMovieList()

            override fun saveCallResult(data: List<MovieItem>) {
                val list = ArrayList<MovieEntity>()

                for (item in data) {
                    list.add(
                        MovieEntity(
                            item.id.toString(),
                            item.title,
                            item.overview,
                            item.releaseDate,
                            BuildConfig.IMG_URL + item.posterPath,
                            false
                        )
                    )
                }

                localDataSource.insertMovie(list)
            }


        }.asLiveData()
    }

    override fun getDetailMovie(id: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> {
                return localDataSource.getMovie(id)
            }

            override fun shouldFetch(data: MovieEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<MovieDetailResponse>> {
                return remoteDataSource.getMovieDetail(id.toInt())
            }

            override fun saveCallResult(data: MovieDetailResponse) {
                val list = ArrayList<MovieEntity>()

                list.add(
                    MovieEntity(
                        data.id.toString(),
                        data.title,
                        data.overview,
                        data.releaseDate,
                        BuildConfig.IMG_URL + data.posterPath,
                        false
                    )
                )
                localDataSource.insertMovie(list)
            }

        }.asLiveData()
    }

    override fun getTvShowList(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvShow(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowItem>>> =
                remoteDataSource.getTvSowList()

            override fun saveCallResult(data: List<TvShowItem>) {
                val list = ArrayList<TvShowEntity>()

                for (item in data) {
                    list.add(
                        TvShowEntity(
                            item.id.toString(),
                            item.name,
                            item.overview,
                            item.firstAirDate,
                            BuildConfig.IMG_URL + item.posterPath,
                            false
                        )
                    )
                }

                localDataSource.insertTvShow(list)
            }

        }.asLiveData()

    }

    override fun getDetailTvShow(id: String): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, TvShowDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> {
                return localDataSource.getTvShow(id)
            }

            override fun shouldFetch(data: TvShowEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<TvShowDetailResponse>> {
                return remoteDataSource.getTvShowDetail(id.toInt())
            }

            override fun saveCallResult(data: TvShowDetailResponse) {
                val list = ArrayList<TvShowEntity>()

                list.add(
                    TvShowEntity(
                        data.id.toString(),
                        data.originalName,
                        data.overview,
                        data.firstAirDate,
                        BuildConfig.IMG_URL + data.posterPath,
                        false
                    )
                )
                localDataSource.insertTvShow(list)
            }

        }.asLiveData()
    }

    override fun setFavoriteMovie(movieEntity: MovieEntity) = appExecutors.diskIO().execute{
        localDataSource.updateMovie(movieEntity)
    }

    override fun setFavoriteTvShow(tvShowEntity: TvShowEntity)= appExecutors.diskIO().execute{
        localDataSource.updateTvShow(tvShowEntity)
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShow(), config).build()
    }
}