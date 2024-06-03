package org.example.utilities

import org.example.list.LinkedList
import spock.lang.Specification

class StringUtilsSpec extends Specification {

    void "check join method"() {
        given:
        def linkedList = new LinkedList().tap {
            add('Groovy')
            add('is')
            add('Great')
        }

        expect:
        StringUtils.join(linkedList) == 'Groovy is Great'
    }

    void "check split method"() {
        given:
        def source = 'Groovy is Great'

        when:
        def result = StringUtils.split(source)

        then:
        verifyAll(result) {
            size() == 3
            get(0) == 'Groovy'
            get(1) == 'is'
            get(2) == 'Great'
        }
    }

}