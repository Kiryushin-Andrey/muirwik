package com.ccfraser.muirwik.testapp

import com.ccfraser.muirwik.components.*
import kotlinx.css.marginBottom
import react.*
import react.dom.div
import styled.css

private val testThemesComponentFunctional = fc<Props> {
    val theme = useTheme()

    div {
        mAppBar(MAppBarColor.primary, MAppBarPosition.static) {
            css { marginBottom = 2.spacingUnits }
            mToolbar {
                mTypography("Theme Functional Component Using Hook - Theme Type '${theme.palette.type}', Primary Color '${theme.palette.primary.main}'", variant = MTypographyVariant.h6, color = MTypographyColor.inherit)
            }
        }
    }
}

fun RBuilder.testThemesComponentFunctional() =  child(testThemesComponentFunctional) {
}
