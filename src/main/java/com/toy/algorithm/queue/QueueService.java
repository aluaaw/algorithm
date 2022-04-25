package com.toy.algorithm.queue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class QueueService {
    // TODO: qSize를 정해두고 해당 값을 infinity로 사용할 수 있도록 하라.
    // TODO: qSize = 10;
    // TODO: 여기에서 구현해야 할 건 원형큐인데 원형큐의 사이즈와 값이 들어왔을 때의 선형큐 위치, 값이 나갔을 때의 선형큐 위치이다.
    // TODO: 값이 들어오면 input은 p +1의 값을 가진다. 여기서 p는 position이다. 보통 position은 index값으로 계산하며 index의 처음값은 0이다.
    // TODO: 값이 나가면 output은 P +1의 값을 가진다. 여기서 p는 똑같이 position이다.
    // TODO: input과 output은 처음 index값에서 시작하므로 0이 된다.
    // TODO: input과 output이 동일하게 되면 공백이거나, 포화상태이거나. size와 input이나 output이 동일했을 때 같은 건 선형큐일 때만 해당되는 이야기. 왜냐면 input을 다 하지 않을 상태에서 output을 조금만 하고 그다음에 input이 가득 찼을 때 = size값과 동일할 때 포화상태는 아니지 않은가.
    // TODO: 그러므로 여기에서 구현되어야 할 건,
    // TODO: 원래 배열에서 새로운 값이 추가되었을 때의 처리 (포화상태인지 아닌지를 확인하는 예외처리)
    // TODO: 원래 배열에서 기존 값을 출력하였을 때의 처리 (공백상태인지 아닌지를 확인하는 예외처리)
    // TODO: 초기값은 0으로 통일한다.
    private final int size = 10;
    private int inputPosition = 0;
    private int outputPosition = 0;
    private final int[] queueArray = new int[size];

    public void circularQueue_enqueue(int value) {
        System.out.println("START enQueue --------");
        enQueue(value);
    }

    public void circularQueue_dequeue() {
        System.out.println("START deQueue --------");
        deQueue();
    }

    // position index 초기화
    public void initQueue() {
        System.out.println("init QUEUE");
        inputPosition = 0;
        outputPosition = 0;
    }

    // 큐 포화상태
    public boolean isFull() {
        System.out.println("CHECK FULL");
        System.out.println("END OF FULL ------------");
        System.out.println("input : " + inputPosition);
        System.out.println("output : " + outputPosition);
        if (inputPosition != 0) {
            for (int queue : queueArray) {
                if (queue == 0) {
                    System.out.println("포화상태가 아님");
                    return false;
                }
            }
            System.out.println("초기값이 아니지만 포화상태");
            return true;
        }
        // 초기값
        return !(inputPosition == outputPosition);
    }

    // 큐 공백상태
    public boolean isEmpty() {
        System.out.println("CHECK EMPTY");
        System.out.println("END OF EMPTY ------------");
        System.out.println("input : " + inputPosition);
        System.out.println("output : " + outputPosition);
        if (outputPosition != 0) {
            for (int queue : queueArray) {
                if (queue != 0) {
                    System.out.println("공백상태가 아님");
                    return false;
                }
            }
            System.out.println("초기값이 아니지만 공백상태");
            return true;
        }
        // 초기값
        return inputPosition == outputPosition;
    }

    // 큐의 삽입연산
    public boolean enQueue(int value) {
        // 큐의 포화상태 확인, 포화상태일 때에는 더 이상 넣을 수 없음
        if (isFull()) {
            System.out.println("FULL IS TRUE");
            return false;
        }
        // 처음일 경우 초기화
        if (inputPosition == -1) {
            initQueue();
        }

        // 추가처리
        queueArray[inputPosition] = value;
        inputPosition = inputPosition + 1;
        System.out.println("after enQueue, input is " + inputPosition);
        System.out.println("queue is " + Arrays.toString(queueArray));

        // position이 동일할 때 초기화한다.
        if (inputPosition == outputPosition) {
            initQueue();
        }

        return true;
    }

    public boolean deQueue() {
        // 큐의 공백상태 확인, 공백상태일 때에는 더 이상 삭제할 수 없음
        if (isEmpty()) {
            System.out.println("EMPTY IS TRUE");
            return false;
        }

        // 값 출력
        queueArray[outputPosition] = 0;
        outputPosition = outputPosition + 1;

        // position이 동일할 때 초기화한다.
        if (inputPosition == outputPosition) {
            initQueue();
        }

        System.out.println("after deQueue, input is " + inputPosition);
        System.out.println("after deQueue, output is " + outputPosition);
        System.out.println("queue is " + Arrays.toString(queueArray));
        return true;
    }
}
