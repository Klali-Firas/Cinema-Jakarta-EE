package firas.l2dis2.cinema8jee.Service;

import firas.l2dis2.cinema8jee.Entity.MovieCategory;
import firas.l2dis2.cinema8jee.dao.DaoMovieCategory;

import java.util.Collection;

public class MovieCategoryService {
    DaoMovieCategory daoMovieCategory = new DaoMovieCategory();

    public void createMovieCategory(MovieCategory movieCategory) {
        daoMovieCategory.addMovieCategory(movieCategory);
    }

    public void modifyMovieCategory(MovieCategory movieCategory) {
        daoMovieCategory.updateMovieCategory(movieCategory);
    }

    public void removeMovieCategory(MovieCategory movieCategory) {
        daoMovieCategory.deleteMovieCategory(movieCategory);
    }

    public MovieCategory getMovieCategory(int movieCategoryId) {
        return daoMovieCategory.getMovieCategory(movieCategoryId);
    }

    public Collection<MovieCategory> getAllMovieCategories() {
        return daoMovieCategory.getAllMovieCategories();
    }


}
