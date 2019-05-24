package tihkoff.taxi.API;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
class PrimaryData {
    String phoneNumber;
    String name;
    String location;
    String destination;
    Boolean status;
    String comment;
    String type;
}
