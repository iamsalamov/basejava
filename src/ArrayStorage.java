/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int a=0; a<size(); a++){
            storage[a] = null;
        }
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
        for (int a = 0; a<size(); a++)
            if (storage[a].uuid == uuid){
                return storage[a];
            }
        return null;
    }

    void delete(String uuid) {
        int count = size();

        for (int b = 0; b < count; b++){
            if (storage[b].uuid == uuid) {
                storage[b] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] array = new Resume[size()];

        for (int a=0; a<size(); a++)
            array[a] = storage[a];

        return array;
        /*return new Resume[0];*/
    }

    int size() {
        int count = 0;
        for (int a = 0; a < storage.length; a++)
            if (storage[a] != null) {
                count++;
            }

        return count;
    }
}
