package jp.co.webfrontier.training.worldclock.model;

import java.time.OffsetDateTime;

import com.google.inject.ImplementedBy;

import jp.co.webfrontier.training.worldclock.City;

@ImplementedBy(WorldClockModelImpl.class)
public interface WorldClockModel {
    public OffsetDateTime getCityDateTime(City city);
}
