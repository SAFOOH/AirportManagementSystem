package services;

import exceptions.EntityNotFoundException;
import models.aircraft.Aircraft;

import java.util.HashMap;
import java.util.Map;

public class GenericRepository<ID, T> {

    private final HashMap<ID, T> GenericRepository = new HashMap<>();

    public void addItem(ID id, T item){GenericRepository.put(id, item);}
    public void removeItem(ID id){GenericRepository.remove(id);}
    public T searchItem(ID id){
        T item = GenericRepository.get(id);
        if (item == null) {
            throw new EntityNotFoundException("The ID (tail number) does not exist");
        }
        return item;
    }

    public void showAllItems(){
        for (Map.Entry<ID, T> entry : GenericRepository.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    // أنا أريد مجموعة من العناصر (T)، ولا يهمني إن كانت مرتبة في ArrayList أو مخزنة في Set
    // المهم أن تعطيني إياها داخل حاوية أستطيع المرور عليها باستخدام حلقة الـ for
    public java.util.Collection<T> getAllValues() {
        return GenericRepository.values(); // يعيد كل الطائرات المخزنة بدون مفاتيحها
    }


}