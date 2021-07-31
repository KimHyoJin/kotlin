package com.example.kotlinstudy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Week01 {

    @Test
    fun `문자열 템플릿 사용시에 한글 문제 확인`() {
        val name: String = "우진"
        println("Hello, ${name}님 반가와요")
    }

    companion object {
        @JvmStatic
        fun provideWhenArray(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(setOf(1, 4, 5), true),
                Arguments.of( setOf(2, 3, 4), true),
                Arguments.of( setOf(2, 4, 5), false),
                Arguments.of(setOf(1), false)
            )
        }
    }


    @ParameterizedTest
    @MethodSource("provideWhenArray")
    @DisplayName("{1,4,5}, {2,3,4}의 array가 넘어온 경우 true 그외 false")
    internal fun `when에 복수개의 값을 넣었을 때 해당 when이 정상적으로 동작되게 구현하기`(given: Set<Int>, expect: Boolean) {
        val actual = when (given) {

            else -> false
        }

        assertThat(actual).isEqualTo(expect)
    }
}