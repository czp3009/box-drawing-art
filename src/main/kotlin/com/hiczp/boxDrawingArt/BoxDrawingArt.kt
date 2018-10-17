package com.hiczp.boxDrawingArt

class BoxDrawingArt {
    companion object {
        @JvmStatic
        fun convert(string: String) = string.toUpperCase().map {
            graphMap[it] ?: throw IllegalArgumentException("The character '$it' is not supported")
        }.let { letterGraphs ->
            if (letterGraphs.isEmpty()) return@let ""
            StringBuilder().apply {
                repeat(3) { line ->
                    repeat(letterGraphs.size) {
                        append(letterGraphs[it][line])
                    }
                    if (line != 3 - 1) appendln()
                }
            }.toString()
        }

        private val graphMap = HashMap<Char, Array<CharArray>>().apply {
            //letter
            val letterGraph = """
                ┌─┐┬┐ ┌─┐┬─┐┌─┐┬─┐┌─┐┬ ┬ ┬  ┬ ┐┌ ┬  ┌┬┐┌┐┌┌─┐┬─┐┌─┐┬─┐┌─┐┌┬┐┐ ┌┐ ┌┬ ┬┬ ┬┬ ┬┌─┐
                ├─┤├┴┐│  │ │├┤ ├┤ │ ┐├─┤ │  │ ├┴┐│  │││││││ │├─┘│ │├┬┘└─┐ │ │ │└┐││││└┬┘└─┤┌─┘
                ┴ ┴┴─┘└─┘┴─┘└─┘┴  └─┘┴ ┴ ┴ └┘ ┴ ┴┴─┘┴ ┴┘└┘└─┘┴  └─┴┴└─└─┘ ┴ └─┘ └┘└┴┘┴ ┴└─┘└─┘
            """.trimIndent().replace("\n", "")
            ('A'..'Z').forEachIndexed { index, letter ->
                put(letter, Array(3) { line ->
                    CharArray(3) { offset ->
                        letterGraph[index * 3 + line * 26 * 3 + offset]
                    }
                })
            }

            //space
            put(' ', Array(3) { "   ".toCharArray() })
        }
    }
}

fun String.toBoxDrawingArt() = BoxDrawingArt.convert(this)
