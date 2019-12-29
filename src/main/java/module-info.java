module com.code.fauch.horcrux.hikari {
    requires com.code.fauch.horcrux;
    requires com.zaxxer.hikari;
    provides com.code.fauch.horcrux.spi.IHorcrux with com.code.fauch.horcrux.hikari.HikariHorcrux;
}