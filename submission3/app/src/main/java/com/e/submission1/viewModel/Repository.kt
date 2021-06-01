package com.e.submission1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.e.session3academy.data.source.remote.RemoteDataSource
import com.e.submission1.BuildConfig
import com.e.submission1.api.response.MovieItem
import com.e.submission1.api.response.TvShowItem
import com.e.submission1.data.MovieEntity
import com.e.submission1.data.TvShowEntity
import com.e.submission1.data.network.response.MovieDetailResponse
import com.e.submission1.data.network.response.TvShowDetailResponse
import com.e.submission1.data.source.remote.DataSource
import com.e.submission1.ui.detail.DetailState
import com.e.submission1.ui.movie.MovieState
import com.e.submission1.ui.tvShow.TvShowState
import com.e.submission1.utils.SingleLiveEvent

class Repository private constructor(private val remoteDataSource: RemoteDataSource) : DataSource {
    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(remoteData: RemoteDataSource): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData).apply { instance = this }
            }
    }

    override fun getMovieList(state: SingleLiveEvent<MovieState>): LiveData<List<MovieEntity>> {
        val listMovieResult = MutableLiveData<List<MovieEntity>>()

        state.value = MovieState.OnLoading(true)
        state.value = MovieState.OnShowData(false)

        remoteDataSource.getMovieList(object : RemoteDataSource.LoadListMovieCallback{
            override fun onResult(movieResponse: List<MovieItem>) {
                val tempMovie = ArrayList<MovieEntity>()

                if (movieResponse.isEmpty()) {
                    state.value = MovieState.OnLoading(false)
                    state.value = MovieState.OnShowData(false)
                    state.value = MovieState.IsEmpty(true)
                } else {
                    for (item in movieResponse) {
                        tempMovie.add(
                            MovieEntity(
                                item.id.toString(),
                                item.title,
                                item.overview,
                                item.releaseDate,
                                BuildConfig.IMG_URL + item.posterPath,
                            )
                        )
                    }
                    state.value = MovieState.OnLoading(false)
                    state.value = MovieState.OnShowData(true)
                    listMovieResult.postValue(tempMovie)
                }
            }

            override fun onFailure(string: String) {
                state.value = MovieState.OnMassage("Load data failed")
                state.value = MovieState.OnLoading(false)
            }

        })

        return listMovieResult
    }

    override fun getTvShowList(state: SingleLiveEvent<TvShowState>): LiveData<List<TvShowEntity>> {
        val listTvShowResult = MutableLiveData<List<TvShowEntity>>()

        state.value = TvShowState.OnLoading(true)
        state.value = TvShowState.OnShowData(false)

        remoteDataSource.getTvShowList(object :RemoteDataSource.LoadListTvShowCallback{
            override fun onResult(tvShowResponse: List<TvShowItem>) {
                val tempTvShow = ArrayList<TvShowEntity>()

                if (tvShowResponse.isEmpty()) {
                    state.value = TvShowState.OnLoading(false)
                    state.value = TvShowState.OnShowData(false)
                    state.value = TvShowState.IsEmpty(true)
                } else {
                    for (item in tvShowResponse) {
                        tempTvShow.add(
                            TvShowEntity(
                                item.id.toString(),
                                item.name,
                                item.overview,
                                item.firstAirDate,
                                BuildConfig.IMG_URL + item.posterPath,
                            )
                        )
                    }
                    state.value = TvShowState.OnLoading(false)
                    state.value = TvShowState.OnShowData(true)
                    listTvShowResult.postValue(tempTvShow)
                }
            }

            override fun onFailure(string: String) {
                state.value = TvShowState.OnMassage("Load data failed")
                state.value = TvShowState.OnLoading(false)
            }

        })

        return listTvShowResult
    }

    override fun getDetailMovie(id: String, state: SingleLiveEvent<DetailState>): LiveData<MovieEntity> {
        val temp = MutableLiveData<MovieEntity>()
        state.value = DetailState.OnLoading(true)
        state.value = DetailState.OnShowData(false)

        remoteDataSource.getMovieDetail(id.toInt(), object : RemoteDataSource.LoadDetailMovieCallback{
            override fun onResult(movieDetailResponse: MovieDetailResponse) {
                val movieResponse: MovieDetailResponse = movieDetailResponse

                if (movieResponse != null) {
                    temp.postValue(
                        MovieEntity(
                            movieResponse.id.toString(),
                            movieResponse.title,
                            movieResponse.overview,
                            movieResponse.releaseDate,
                            BuildConfig.IMG_URL + movieResponse.posterPath
                        )
                    )

                    state.value = DetailState.OnLoading(false)
                    state.value = DetailState.OnShowData(true)

                }else{
                    state.value = DetailState.OnMassage("Load data failed")
                    state.value = DetailState.OnLoading(false)
                }
            }

            override fun onFailure(string: String) {
                state.value = DetailState.OnMassage("Load data failed")
                state.value = DetailState.OnLoading(false)
            }

        })

        return temp
    }

    override fun getDetailTvShow(id: String, state: SingleLiveEvent<DetailState>): LiveData<TvShowEntity> {
        val temp = MutableLiveData<TvShowEntity>()
        state.value = DetailState.OnLoading(true)
        state.value = DetailState.OnShowData(false)

        remoteDataSource.getTvShowDetail(id.toInt(), object :RemoteDataSource.LoadDetailTvShowCallback{
            override fun onResult(tvShowDetailResponse: TvShowDetailResponse) {
                val movieResponse: TvShowDetailResponse = tvShowDetailResponse

                if (movieResponse != null) {
                    temp.postValue(
                        TvShowEntity(
                            movieResponse.id.toString(),
                            movieResponse.originalName,
                            movieResponse.overview,
                            movieResponse.firstAirDate,
                            BuildConfig.IMG_URL + movieResponse.posterPath
                        )
                    )

                    state.value = DetailState.OnLoading(false)
                    state.value = DetailState.OnShowData(true)

                }else{
                    state.value = DetailState.OnMassage("Load data failed")
                    state.value = DetailState.OnLoading(false)
                }
            }

            override fun onFailure(string: String) {
                state.value = DetailState.OnMassage("Load data failed")
                state.value = DetailState.OnLoading(false)
            }

        })

        return temp
    }

}