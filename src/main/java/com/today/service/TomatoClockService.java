package com.today.service;

import com.today.entity.Todo;
import com.today.entity.TomatoClock;

public interface TomatoClockService {
    int addTomatoClock(TomatoClock tomatoClock);

    int updateTomatoClock(TomatoClock tomatoClock);

    int SetTomatoClockState(TomatoClock tomatoClock, Todo todo);

    int OverTomatoClock(TomatoClock tomatoClock);

    TomatoClock getTomatoClockById(int tomatoClockID);
    int SleepTomatoClock(TomatoClock tomatoClock);
    int getTomatoClockID ();
}
