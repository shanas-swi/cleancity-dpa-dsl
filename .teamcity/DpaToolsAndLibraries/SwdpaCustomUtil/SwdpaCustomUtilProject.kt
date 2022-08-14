package DpaToolsAndLibraries.SwdpaCustomUtil

import DpaToolsAndLibraries.SwdpaCustomUtil.vcsRoots.SwdpaCustomUtilConnector
import buildTypes.SwdpaCustomUtilBuildConfiguration
import jetbrains.buildServer.configs.kotlin.v2019_2.*

object SwdpaCustomUtilProject : Project({
    name = "Dpa Custom Util"

    params {
        param("teamcity.agent.hostname", "build-agent-linux-dpa")
        param("gitDefaultBranch", "refs/heads/main")
//        param("gitBranchSpecification", """
//            +:refs/heads/*
//            -:refs/heads/release/*
        param("gitBranchSpecification", """
            -:refs/heads/*       
        """.trimIndent())
        param("majorVersionNumber", "2022")
        param("minorVersionNumber", "4")
        param("revisionNumber", "0")

        param("dpa.build.counter", "${SwdpaCustomUtilBuildConfiguration.depParamRefs["build.counter"]}")
        param("dpa.mvn.snapshot.version", "%majorVersionNumber%.%minorVersionNumber%.%dpa.build.counter%-SNAPSHOT")
        param("maven.common.properties", "-Djarsign.enabled=false")
        param("maven.project.list", "!web/ng2,!web/war")
    }

    vcsRoot(SwdpaCustomUtilConnector)

    buildType(SwdpaCustomUtilBuildConfiguration)
})