package bookQueries.service.Adapter;

import bookQueries.domain.Review;
import bookQueries.service.Dto.ReviewDtO;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter {
    public static Review getReviewFromReviewDto(ReviewDtO reviewDTO){
        return new Review(reviewDTO.getReviewId(), reviewDTO.getIsbn(), reviewDTO.getReviewRating(),reviewDTO.getCustomerName(), reviewDTO.getDescription());
    }
}
