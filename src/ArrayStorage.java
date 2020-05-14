/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        storage = null;
    }

    void save(Resume r) {
        int count = 0;
        for (int a = 0; a < storage.length; a++)
            if (storage[a] != null) {
                count++;
            }

        storage[count] = r;
    }

    Resume get(String uuid) {
        for (Resume arr: storage){
            if (arr.uuid == uuid) {
                return arr;
            } else {
                return null;
            }
        }
        return null;
    }

    void delete(String uuid) {
        int count = 0;
        for (int a = 0; a < storage.length; a++)
            if (storage[a] != null) {
                count++;
            }

        for (int b = 0; b < count; b++){
            if (storage[b].uuid == uuid) {
                storage[b] = null;
                storage[b] = storage[count];
                storage[count] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return storage;
        /*return new Resume[0];*/
    }

    int size() {
        return storage.length;
    }
}
