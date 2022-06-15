package com.ccfraser.muirwik.components

import csstype.ClassName
import kotlinx.js.jso
import react.*
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
    className: ClassName? = null,
    handler: StyledHandler<MSvgIconProps>? = null
) {
    createStyled(svgIconComponentType, className, handler) {
        attrs.color = color
        htmlColor?.let { attrs.htmlColor = it }
        attrs.fontSize = fontSize

        val props: SVGPathProps = jso {
            d = svgPath
        }

        childList.add(createElement(IntrinsicType("path"), props))
    }
}

external interface SVGPathProps : PropsWithClassName {
    var d: String
}

