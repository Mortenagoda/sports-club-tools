package works.softwarethat.sports.club.tools.model.community;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Load;
import works.softwarethat.sports.club.tools.model.club.Club;

/**
 * This is just an address reference. Aws.dk modelled any address perfectly for us so let's not do that again.
 *
 * @author Morten Andersen (mortena@gmail.com)
 */
public class Address {
    @Id
    Long id;

    /**
     * aws.dk id for the address.
     */
    String awsAddressId;

    @Load
    Ref<Club> club;
}
