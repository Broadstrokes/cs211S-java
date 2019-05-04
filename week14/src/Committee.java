import java.time.LocalDate;

/**
 * Write an immutable class to describe a Committee. A committee object consists of:
 *
 * String name
 * int numMemberes
 * Member committeeChair (download the Member class from here. NB: this class is not immutable!)
 * LocalDate formationDate
 */
public final class Committee {
    private final String name;
    private final int numMembers;
    private final Member committeeChair;
    private final LocalDate formationDate;

    public Committee(String name, int numMembers, Member committeeChair, LocalDate formationDate) {
        this.name = name;
        this.numMembers = numMembers;
        this.formationDate = formationDate;

        Member committeeChairCopy = new Member(
                committeeChair.getFirstName(),
                committeeChair.getLastName(),
                committeeChair.getAge(),
                committeeChair.getStatus()
        );

        this.committeeChair = committeeChairCopy;
    }

    public String getName() {
        return name;
    }

    public int getNumMembers() {
        return numMembers;
    }

    public Member getCommitteeChair() {
        Member committeeChairCopy = new Member(
                this.committeeChair.getFirstName(),
                this.committeeChair.getLastName(),
                this.committeeChair.getAge(),
                this.committeeChair.getStatus()
        );

        return committeeChairCopy;
    }

    public LocalDate getFormationDate() {
        return formationDate;
    }
}
