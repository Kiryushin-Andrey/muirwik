package com.ccfraser.muirwik.testapp

import com.ccfraser.muirwik.components.*
import kotlinx.css.marginBottom
import react.*
import react.dom.div
import styled.css

class TestThemeComponent : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        div {
            themeContext.Consumer { theme ->
                mAppBar(MAppBarColor.primary, MAppBarPosition.static) {
                    css { marginBottom = 2.spacingUnits }
                    mToolbar {
                        mTypography("Theme Component Using Context - Theme Type '${theme.palette.type}', Primary Color '${theme.palette.primary.main}'", variant = MTypographyVariant.h6, color = MTypographyColor.inherit)
                    }
                }
            }
        }
    }
}


fun RBuilder.testThemeComponent() = child(TestThemeComponent::class) {}

