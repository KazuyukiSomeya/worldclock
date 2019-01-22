package jp.co.webfrontier.training.worldclock.model;

import java.time.OffsetDateTime;

import com.google.inject.ImplementedBy;

@ImplementedBy(WorldClockModelImpl.class)
public interface WorldClockModel {
    public OffsetDateTime getCityDateTime();
}
