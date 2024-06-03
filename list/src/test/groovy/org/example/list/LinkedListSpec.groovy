package org.example.list

import spock.lang.Specification

class LinkedListSpec extends Specification {

    def "test constructor"() {
        given: "a new LinkedList"
        def list = new LinkedList()

        expect: "the list size should be 0"
        list.size() == 0
    }

    def "test add"() {
        given: "a new LinkedList"
        def list = new LinkedList()

        when: "adding an element 'one' to the list"
        list.add('one')

        then: "the list size should be 1 and the first element should be 'one'"
        list.size() == 1
        list.get(0) == 'one'

        when: "adding another element 'two' to the list"
        list.add('two')

        then: "the list size should be 2 and the second element should be 'two'"
        list.size() == 2
        list.get(1) == 'two'
    }

    def "test remove"() {
        given: "a new LinkedList with elements 'one' and 'two'"
        def list = new LinkedList()
        list.add('one')
        list.add('two')

        when: "removing the element 'one'"
        def result = list.remove('one')

        then: "the remove operation should be successful, the list size should be 1, and the first element should be 'two'"
        result
        list.size() == 1
        list.get(0) == 'two'

        when: "removing the element 'two'"
        result = list.remove('two')

        then: "the remove operation should be successful and the list size should be 0"
        result
        list.size() == 0
    }

    def "test remove missing element"() {
        given: "a new LinkedList with elements 'one' and 'two'"
        def list = new LinkedList()
        list.add('one')
        list.add('two')

        when: "attempting to remove a non-existing element 'three'"
        def result = list.remove('three')

        then: "the remove operation should fail and the list size should remain 2"
        !result
        list.size() == 2
    }
}