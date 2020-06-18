package org.reciprocity.aaservice.form;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.reciprocity.aaservice.repository.member.Name;
import org.reciprocity.aaservice.model.MemberName;

import org.apache.commons.codec.digest.DigestUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormMapperTest {
    private FormMapper mapper
            = Mappers.getMapper(FormMapper.class);
    @Test
    public void testNameToNameEntityMapping() {
        MemberName name = new MemberName();
        name.setFirstName("Joe");
        name.setLastName("Smith");

        Name namesEntity = mapper.nameToEntity(name);

        Name expectedNameEntity = new Name();

        expectedNameEntity.setFirstName("Joe");
        expectedNameEntity.setLastName("Smith");

        assertEquals(expectedNameEntity.getFirstName(), namesEntity.getFirstName());
        assertEquals(expectedNameEntity.getLastName(), namesEntity.getLastName());
    }

    @Test
    public void testMD5Hash() {
        String hash = "35454B055CC325EA1AF2126E27707052";
        String password = "ILoveJava";

        String md5Hex = DigestUtils
                .md5Hex(password).toUpperCase();

        assertThat(md5Hex, equalTo(hash));
    }
}
