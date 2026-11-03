package com.senai.carteirinhadigital.app.navigation.professor

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
import com.senai.carteirinhadigital.feature.auth.domain.model.PerfilAcesso
import com.senai.carteirinhadigital.feature.auth.domain.model.UsuarioLogado
import com.senai.carteirinhadigital.feature.professor.home.presentation.screen.HomeProfessorScreen
import com.senai.carteirinhadigital.feature.professor.turmas.domain.repository.TurmaProfessorRepository
import com.senai.carteirinhadigital.feature.professor.turmas.presentation.factory.TurmaProfessorViewModelFactory
import com.senai.carteirinhadigital.feature.professor.turmas.presentation.TurmaProfessorViewModel
import com.senai.carteirinhadigital.feature.professor.turmas.presentation.screen.TurmasProfessorScreen
import com.senai.carteirinhadigital.feature.professor.unidadecurricular.domain.repository.UnidadeCurricularProfessorRepository
import com.senai.carteirinhadigital.feature.professor.unidadecurricular.presentation.UnidadeCurricularProfessorViewModel
import com.senai.carteirinhadigital.feature.professor.unidadecurricular.presentation.factory.UnidadeCurricularProfessorViewModelFactory
import com.senai.carteirinhadigital.feature.professor.unidadecurricular.presentation.screen.UnidadesProfessorScreen
import kotlinx.coroutines.flow.StateFlow

fun NavGraphBuilder.professorNavGraph(
    navController: NavHostController,
    usuarioLogadoFlow: StateFlow<UsuarioLogado?>,
    turmaProfessorRepository: TurmaProfessorRepository,
    unidadeCurricularProfessorRepository: UnidadeCurricularProfessorRepository,
    darkTheme: Boolean,
    onDarkThemeChange: (Boolean) -> Unit,
    onLogout: () -> Unit,
    onSessaoAusente: () -> Unit,
    onPerfilInvalido: (PerfilAcesso) -> Unit
) {
    navigation(startDestination = ProfessorRoutes.HOME, route = GraphRoutes.PROFESSOR) {
        composable(ProfessorRoutes.HOME) {
            ProfileGuard(usuarioFlow = usuarioLogadoFlow, perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente, onPerfilInvalido = onPerfilInvalido) { usuario ->
                AppShell(title = "Início", usuarioLogado = usuario, canNavigateBack = false,
                    darkTheme = darkTheme, onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = {}, onLogout = onLogout) { innerPadding ->
                    HomeProfessorScreen(
                        usuarioLogado = usuario,
                        onTurmasClick = { navController.navigate(ProfessorRoutes.TURMAS) },
                        onUnidadesCurricularesClick = { navController.navigate(ProfessorRoutes.UNIDADES_CURRICULARES) },
                        modifier = Modifier.fillMaxSize().padding(innerPadding)
                    )
                }
            }
        }
        composable(ProfessorRoutes.TURMAS) {
            ProfileGuard(usuarioFlow = usuarioLogadoFlow, perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente, onPerfilInvalido = onPerfilInvalido) { usuario ->
                val factory = remember(turmaProfessorRepository) {
                    TurmaProfessorViewModelFactory(
                        turmaProfessorRepository
                    )
                }
                val vm: TurmaProfessorViewModel = viewModel(factory = factory)
                AppShell(title = "Minhas Turmas", usuarioLogado = usuario, canNavigateBack = true,
                    darkTheme = darkTheme, onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = { navController.popBackStack() }, onLogout = onLogout) { innerPadding ->
                    TurmasProfessorScreen(vm, Modifier.fillMaxSize().padding(innerPadding))
                }
            }
        }
        composable(ProfessorRoutes.UNIDADES_CURRICULARES) {
            ProfileGuard(usuarioFlow = usuarioLogadoFlow, perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente, onPerfilInvalido = onPerfilInvalido) { usuario ->
                val factory = remember(unidadeCurricularProfessorRepository) {
                    UnidadeCurricularProfessorViewModelFactory(unidadeCurricularProfessorRepository)
                }
                val vm: UnidadeCurricularProfessorViewModel = viewModel(factory = factory)
                AppShell(title = "Unidades Curriculares", usuarioLogado = usuario, canNavigateBack = true,
                    darkTheme = darkTheme, onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = { navController.popBackStack() }, onLogout = onLogout) { innerPadding ->
                    UnidadesProfessorScreen(vm, Modifier.fillMaxSize().padding(innerPadding))
                }
            }
        }
    }
}
