import com.sun.org.apache.xpath.internal.objects.XNull;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (get(r.uuid) == null) {
            storage[size] = r;
            size++;

            //System.out.println(Arrays.toString(storage));
            //System.out.println(size);
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++)
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        return null;
    }

    void delete(String uuid) {
        int count = size;
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = storage[i + 1];
            }
        }

        size--;
        //System.out.println(Arrays.toString(storage));
        //System.out.println(size);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] Resumes = new Resume[size];

        for (int i = 0; i < size; i++)
            Resumes[i] = storage[i];

        return Resumes;
        /*return new Resume[0];*/
    }

    int size() {
        return size;
    }
}
