module DesignPatterns {
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;
    requires com.google.gson;

    exports Task19Mediator to javafx.graphics;
    exports Task11Memento to javafx.graphics;
    exports Task14Builder to javafx.graphics;
    exports Task17Flyweight to javafx.graphics;
    exports Task18Prototype to javafx.graphics;
}
