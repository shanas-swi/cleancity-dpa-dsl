package DpaToolsAndLibraries.SwdpaCustomUtil

import DpaToolsAndLibraries.SwdpaCustomUtil.vcsRoots.SwdpaCustomUtilConnector
import buildTypes.SwdpaCustomUtilBuildConfiguration
import jetbrains.buildServer.configs.kotlin.v2019_2.*

object SwdpaCustomUtilProject : Project({
    name = "Dpa Custom Util"

    vcsRoot(SwdpaCustomUtilConnector)

    buildType(SwdpaCustomUtilBuildConfiguration)
})