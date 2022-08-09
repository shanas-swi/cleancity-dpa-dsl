package commons

enum class TargetEnvironment(val condition: () -> Boolean) {
    ALL({ true }),
    ESX({ isEsx() }),
    DEVEL({ isDevel() }),
    STAGING({ isStaging() }),
    PRODUCTION({ isProduction() })
}
