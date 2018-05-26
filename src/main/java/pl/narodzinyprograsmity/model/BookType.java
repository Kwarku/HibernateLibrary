package pl.narodzinyprograsmity.model;

public enum BookType {
    COMICS("comics"), FANTASY("fantasy"), DEFAULT("default");
    private String type;

    BookType(String type) {
        this.type = type;
    }

    public static BookType getBookType(String type) {
        for (BookType bookType : values()) {
            if (bookType.type.equals(type)){
                return bookType;
            }
        }
        return DEFAULT;
    }


    @Override
    public String toString() {
        return type;
    }
}