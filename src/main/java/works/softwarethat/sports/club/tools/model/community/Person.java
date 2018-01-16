package works.softwarethat.sports.club.tools.model.community;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import works.softwarethat.sports.club.tools.model.club.Club;

/**
 * Any person in the system. There should only be one person in the system no matter the role he/she is playing.
 * 
 * @author Morten Andersen (mortena@gmail.com)
 */
@Entity
public class Person {
    @Id
    Long id;
    private String firstName;

    private String lastName;

    private Ref<Address> homeAddress;

    private Ref<Club> club;

    public Ref<Club> getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = Ref.create(club);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Ref<Address> getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Ref<Address> homeAddress) {
        this.homeAddress = homeAddress;
    }
}
