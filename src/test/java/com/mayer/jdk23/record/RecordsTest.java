package com.mayer.jdk23.record;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RecordsTest {

    @Test
    public void checkRecord() {
    	Person person = new Person("John Doe", 30);
        assertThat(person, notNullValue());
        assertThat(person.name(), is("John Doe"));
        assertThat(person.age(), is(30));
    }

}