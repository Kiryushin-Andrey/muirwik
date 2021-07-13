package com.ccfraser.muirwik.components

import kotlinext.js.jsObject
import react.ComponentType
import react.RBuilder
import react.RProps
import react.createElement
import styled.StyledHandler

@JsModule("@material-ui/core/SvgIcon")
private external val svgIconModule: dynamic

@Suppress("UnsafeCastFromDynamic")
private val svgIconComponentType: ComponentType<MSvgIconProps> = svgIconModule.default

@Suppress("EnumEntryName")
enum class SvgShapeRendering {
    auto, optimizeSpeed, crispEdges, geometricPrecision
}

external interface MSvgIconProps : MIconProps {
    var htmlColor: String?
    var titleAccess: String?
    var viewBox: String?
}
var MSvgIconProps.shapeRendering by EnumPropToStringNullable(SvgShapeRendering.values())

fun RBuilder.mSvgIcon(
        svgPath: String,
        color: MIconColor = MIconColor.inherit,
        htmlColor: String? = null,
        fontSize: MIconFontSize = MIconFontSize.default,

        addAsChild: Boolean = true,
        className: String? = null,
        handler: StyledHandler<MSvgIconProps>? = null) = createStyled(svgIconComponentType, addAsChild) {
    attrs.color = color
    htmlColor?.let { attrs.htmlColor = it }
    attrs.fontSize = fontSize

    val props: RProps =  jsObject {  }
    props.asDynamic().d = svgPath

    childList.add(createElement("path", props))

    setStyledPropsAndRunHandler(className, handler)
}


