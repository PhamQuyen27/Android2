package cf.vandit.streamingapp_nhom12.request;


import cf.vandit.streamingapp_nhom12.network.movie.GenreMoviesResponse;
import cf.vandit.streamingapp_nhom12.network.movie.SimilarMoviesResponse;
import cf.vandit.streamingapp_nhom12.network.movie.Movie;
import cf.vandit.streamingapp_nhom12.network.movie.MovieCreditsResponse;
import cf.vandit.streamingapp_nhom12.network.movie.NowShowingMoviesResponse;
import cf.vandit.streamingapp_nhom12.network.movie.PopularMoviesResponse;
import cf.vandit.streamingapp_nhom12.network.movie.TopRatedMoviesResponse;
import cf.vandit.streamingapp_nhom12.network.series.AiringTodaySeriesResponse;
import cf.vandit.streamingapp_nhom12.network.series.OnTheAirSeriesResponse;
import cf.vandit.streamingapp_nhom12.network.series.PopularSeriesResponse;
import cf.vandit.streamingapp_nhom12.network.series.SeasonDetailsResponse;
import cf.vandit.streamingapp_nhom12.network.series.Series;
import cf.vandit.streamingapp_nhom12.network.series.SeriesCreditsResponse;
import cf.vandit.streamingapp_nhom12.network.series.SimilarSeriesResponse;
import cf.vandit.streamingapp_nhom12.network.series.TopRatedSeriesResponse;
import cf.vandit.streamingapp_nhom12.network.videos.TrailersResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    // Movie
    @GET("movie/now_playing")
    Call<NowShowingMoviesResponse> getNowShowingMovies(@Query("api_key") String apiKey, @Query("page") Integer page, @Query("region") String region);

    @GET("movie/popular")
    Call<PopularMoviesResponse> getPopularMovies(@Query("api_key") String api_key, @Query("page") int page);

    @GET("movie/top_rated")
    Call<TopRatedMoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey, @Query("page") Integer page, @Query("region") String region);

    @GET("movie/{movie_id}")
    Call<Movie> getMovieDetails(@Path("movie_id") Integer movieId, @Query("api_key") String apiKey);

    @GET("movie/{id}/videos")
    Call<TrailersResponse> getMovieVideos(@Path("id") Integer movieId, @Query("api_key") String apiKey);

    @GET("movie/{id}/credits")
    Call<MovieCreditsResponse> getMovieCredits(@Path("id") Integer movieId, @Query("api_key") String apiKey);

    @GET("movie/{id}/similar")
    Call<SimilarMoviesResponse> getSimilarMovies(@Path("id") Integer movieId, @Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("discover/movie")
    Call<GenreMoviesResponse> getMoviesByGenre(@Query("api_key") String apiKey, @Query("with_genres") Integer genreNumber, @Query("page") Integer page);

    // Series
    @GET("tv/airing_today")
    Call<AiringTodaySeriesResponse> getAiringTodaySeries(@Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("tv/on_the_air")
    Call<OnTheAirSeriesResponse> getOnTheAirSeries(@Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("tv/popular")
    Call<PopularSeriesResponse> getPopularSeries(@Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("tv/top_rated")
    Call<TopRatedSeriesResponse> getTopRatedSeries(@Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("tv/{id}")
    Call<Series> getSeriesDetails(@Path("id") Integer tvShowId, @Query("api_key") String apiKey, @Query("append_to_response") String append_to_response);

    @GET("tv/{id}/videos")
    Call<TrailersResponse> getSeriesVideos(@Path("id") Integer movieId, @Query("api_key") String apiKey);

    @GET("tv/{id}/credits")
    Call<SeriesCreditsResponse> getSeriesCredits(@Path("id") Integer movieId, @Query("api_key") String apiKey);

    @GET("tv/{id}/similar")
    Call<SimilarSeriesResponse> getSimilarSeries(@Path("id") Integer movieId, @Query("api_key") String apiKey, @Query("page") Integer page);

    @GET("tv/{id}/season/{season}")
    Call<SeasonDetailsResponse> getSeasonDetails(@Path("id") Integer id, @Path("season") Integer season_number, @Query("api_key") String apiKey);

}
