package DpaToolsAndLibraries

import _Self.vcsRoots.CustomUtilConnector
import buildTypes.CustomUtilBuildConfiguration
import jetbrains.buildServer.configs.kotlin.v2019_2.*

object DpaToolsAndLibrariesProject : Project({
    id("DpaToolsAndLibraries")
    name = "DPA Tools and Libraries"

    vcsRoot(CustomUtilConnector)

    buildType(CustomUtilBuildConfiguration)

})
