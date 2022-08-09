package _Self

import _Self.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2019_2.DslContext
import jetbrains.buildServer.configs.kotlin.v2019_2.Project

object DPACleanCityProject : Project({
    name = "DPA - CleanCity"

    vcsRoot(DpaGitConnector)
    vcsRoot(CustomUtilConnector)

    subProject(DpaToolsAndLibraries.DpaToolsAndLibrariesProject)
    subProject(DpaInstallers.DpaInstallersProject)
})
