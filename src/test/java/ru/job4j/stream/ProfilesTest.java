package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void whenCollect2profiles() {
        List<Profile> profileList = List.of(
                new Profile(new Address("London", "Queen street", 10, 4)),
                new Profile(new Address("", "Arbat street", 14, 5))
        );
        Profiles pr = new Profiles();
        List<Address> rsl = pr.collect(profileList);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("London", "Queen street", 10, 4));
        expected.add(new Address("", "Arbat street", 14, 5));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollect3profiles() {
        List<Profile> profileList = List.of(
                new Profile(new Address("London", "Queen street", 10, 4)),
                new Profile(new Address("Moscow", "Arbat street", 14, 5)),
                new Profile(new Address("Tokyo", "Yakuza street", 1, 3))
        );
        Profiles pr = new Profiles();
        List<Address> rsl = pr.collect(profileList);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("London", "Queen street", 10, 4));
        expected.add(new Address("Moscow", "Arbat street", 14, 5));
        expected.add(new Address("Tokyo", "Yakuza street", 1, 3));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectEmptyProfile() {
        List<Profile> profileList = new ArrayList<>();
        Profiles pr = new Profiles();
        List<Address> rsl = pr.collect(profileList);
        List<Address> expected = new ArrayList<>();
        assertThat(rsl, is(expected));
    }
}
