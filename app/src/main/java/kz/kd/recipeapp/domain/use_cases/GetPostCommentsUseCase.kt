package kz.kd.recipeapp.domain.use_cases

//private const val NO_LIMIT = -1
//
//class GetPostCommentsUseCase(private val commentsRepository: CommentsRepository) {
//    suspend operator fun invoke(postId: Int, limitBy: Int = NO_LIMIT): List<Comment> {
//        if (limitBy == NO_LIMIT || limitBy < 0) {
//            return commentsRepository.getPostComments(postId)
//        }
//
//        //This takes first limitBy elements
//        return commentsRepository.getPostComments(postId).take(limitBy)
//    }
//
//}