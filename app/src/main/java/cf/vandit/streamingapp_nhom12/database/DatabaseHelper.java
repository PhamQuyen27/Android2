package cf.vandit.streamingapp_nhom12.database;

import android.content.Context;

import cf.vandit.streamingapp_nhom12.database.movies.FavMovie;
import cf.vandit.streamingapp_nhom12.database.movies.MovieDatabase;
import cf.vandit.streamingapp_nhom12.database.search.RecentSearch;
import cf.vandit.streamingapp_nhom12.database.search.SearchDatabase;
import cf.vandit.streamingapp_nhom12.database.series.FavSeries;
import cf.vandit.streamingapp_nhom12.database.series.SeriesDatabase;

public class DatabaseHelper {
    public static boolean isFavMovie(Context context, Integer movieId){
        if(movieId == null) return false;
        FavMovie f = MovieDatabase.getInstance(context).movieDao().getMovieById(movieId);
        return f != null;
    }

    public static boolean isFavSeries(Context context, Integer seriesId){
        if(seriesId == null) return false;
        FavSeries f = SeriesDatabase.getInstance(context).seriesDao().getSeriesById(seriesId);
        return f != null;
    }

    public static boolean isRecentlySearched(Context context, String name){
        if(name == null) return false;
        RecentSearch recentSearch = SearchDatabase.getInstance(context).searchDao().getSearchesByName(name);
        return recentSearch != null;
    }
}
