package tihkoff.taxi.API;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PrimaryData {
    String phoneNumber;
    String location;
    String destination;
    String name;
    Boolean status;
}
