package works.softwarethat.sports.club.tools.model.club;

import com.googlecode.objectify.annotation.Id;

/**
 * @author Morten Andersen (mortena@gmail.com)
 */
public class Club {
    private @Id
    Long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
