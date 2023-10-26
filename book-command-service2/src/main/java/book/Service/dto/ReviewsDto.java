package book.Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ReviewsDto {
    List<ReviewDtO> reviewDtOS;
}
