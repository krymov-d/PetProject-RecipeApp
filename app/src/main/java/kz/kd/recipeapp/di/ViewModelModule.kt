package kz.kd.recipeapp.di

import org.koin.dsl.module

val viewModelModule = module {
//    viewModel { PostsViewModel(get()) }
//    viewModel { (postId: Int) -> //Так я позволяю передавать айди поста во время работы приложения
//        PostDetailsViewModel(
//            postId = postId,
//            getPostByIdUseCase = get(),
//            getPostCommentsUseCase = get(),
//            getUserUseCase = get()
//        )
//    }
//    viewModel { (userId: Int, currentUserId: Int) ->
//        UserProfileViewModel(
//            userId = userId,
//            currentUserId = currentUserId,
//            getUserUseCase = get()
//        )
//    }
}