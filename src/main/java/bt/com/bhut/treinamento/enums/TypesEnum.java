package bt.com.bhut.treinamento.enums;

import lombok.Getter;

@Getter
public enum TypesEnum {
    text("text"),
    number("number"),
    datetime("datetime"),
    datetimeLocal("datetime-local"),
    button("button"),
    checkbox("checkbox"),
    color("color"),
    date("date"),
    email("email"),
    file("file"),
    hidden("hidden"),
    image("image"),
    month("month"),
    password("password"),
    radio("radio"),
    range("range"),
    reset("reset"),
    search("search"),
    submit("submit"),
    tel("tel"),
    time("time"),
    url("url"),
    week("week");

    final String type;

    TypesEnum(String type) {
        this.type = type;
    }
}
