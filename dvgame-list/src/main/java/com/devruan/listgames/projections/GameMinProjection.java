package com.devruan.listgames.projections;

public interface GameMinProjection {
    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
