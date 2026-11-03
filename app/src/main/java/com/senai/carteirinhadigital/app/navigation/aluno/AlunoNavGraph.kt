package com.senai.carteirinhadigital.app.navigation.aluno

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.senai.carteirinhadigital.app.navigation.GraphRoutes
import com.senai.carteirinhadigital.app.navigation.ProfileGuard
import com.senai.carteirinhadigital.app.ui.AppShell
import com.senai.carteirinhadigital.feature.auth.domain.model.UsuarioLogado
import com.senai.carteirinhadigital.feature.aluno.carteirinha.presentation.screen.CarteirinhaScreen
import com.senai.carteirinhadigital.feature.aluno.home.presentation.screen.HomeScreen
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.repository.UnidadeCurricularRepository
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.presentation.UnidadeCurricularViewModel
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.presentation.factory.UnidadeCurricularViewModelFactory
import com.senai.carteirinhadigital.feature.aluno.unidadecurricular.presentation.screen.UnidadeCurricularScreen
import com.senai.carteirinhadigital.feature.auth.domain.model.PerfilAcesso
import kotlinx.coroutines.flow.StateFlow

fun NavGraphBuilder.alunoNavGraph(
    navController: NavHostController,
    usuarioLogadoFlow: StateFlow<UsuarioLogado?>,
    unidadeCurricularRepository: com.senai.carteirinhadigital.feature.aluno.unidadecurricular.domain.repository.UnidadeCurricularRepository,
    darkTheme: Boolean,
    onDarkThemeChange: (Boolean) -> Unit,
    onLogout: () -> Unit,
    onSessaoAusente: () -> Unit,
    onPerfilInvalido: (PerfilAcesso) -> Unit
) {
    navigation(
        startDestination = AlunoRoutes.HOME,
        route = GraphRoutes.ALUNO
    ) {
        composable(
            route = AlunoRoutes.HOME
        ) {
            ProfileGuard(
                usuarioFlow = usuarioLogadoFlow,
                perfilEsperado = PerfilAcesso.ALUNO,
                onSessaoAusente = onSessaoAusente,
                onPerfilInvalido = onPerfilInvalido
            ) { usuario ->

                AppShell(
                    title = "Início",
                    usuarioLogado = usuario,
                    canNavigateBack = false,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = {},
                    onLogout = onLogout
                ) { innerPadding ->
                    HomeScreen(
                        usuarioLogado = usuario,
                        onCarteirinhaClick = {
                            navController.navigate(AlunoRoutes.CARTEIRINHA)
                        },
                        onUnidadesCurricularesClick = {
                            navController.navigate(AlunoRoutes.UNIDADES_CURRICULARES)
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }

        composable(route = AlunoRoutes.CARTEIRINHA) {

            ProfileGuard(
                usuarioFlow = usuarioLogadoFlow,
                perfilEsperado = PerfilAcesso.ALUNO,
                onSessaoAusente = onSessaoAusente,
                onPerfilInvalido = onPerfilInvalido
            ) { usuario ->

                AppShell(
                    title = "Carteirinha",
                    usuarioLogado = usuario,
                    canNavigateBack = true,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = {
                        navController.popBackStack()
                    },
                    onLogout = onLogout
                ) { innerPadding ->
                    CarteirinhaScreen(
                        usuarioLogado = usuario,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }

        composable(route = AlunoRoutes.UNIDADES_CURRICULARES) {

            ProfileGuard(
                usuarioFlow = usuarioLogadoFlow,
                perfilEsperado = PerfilAcesso.ALUNO,
                onSessaoAusente = onSessaoAusente,
                onPerfilInvalido = onPerfilInvalido
            ) { usuario ->

                val factory = remember(unidadeCurricularRepository) {
                    _root_ide_package_.com.senai.carteirinhadigital.feature.aluno.unidadecurricular.presentation.factory.UnidadeCurricularViewModelFactory(
                        repository = unidadeCurricularRepository
                    )
                }

                val unidadeCurricularViewModel: com.senai.carteirinhadigital.feature.aluno.unidadecurricular.presentation.UnidadeCurricularViewModel = viewModel(
                    factory = factory
                )
                AppShell(
                    title = "Unidades Curriculares",
                    usuarioLogado = usuario,
                    canNavigateBack = true,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = {
                        navController.popBackStack()
                    },
                    onLogout = onLogout
                ) { innerPadding ->
                    _root_ide_package_.com.senai.carteirinhadigital.feature.aluno.unidadecurricular.presentation.screen.UnidadeCurricularScreen(
                        viewModel = unidadeCurricularViewModel,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}