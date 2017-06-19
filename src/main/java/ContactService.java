
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class ContactService {
    public static void main(String[] args) {
        ContactService service = new ContactService();
        Contact c1 = service.new Contact("Kevin", "12345566");
        Contact c2 = service.new Contact("Ken", "123455661");
        Contact c3 = service.new Contact("Bob", "123455661");
        service.add(c1);
        service.add(c2);
        service.add(c3);
        System.out.println(service.findByName("Ke").size());
        service.findByName("Ke").forEach(it -> System.out.println(it.name));
    }

    HashMap<String, Contact> contactMap;

    public ContactService() {
        this.contactMap = new HashMap<String, Contact>();
    }

    void add(Contact c) {
        contactMap.put(c.name, c);
    }

    List<Contact> findByName(String name) {
        return contactMap.entrySet().stream()
                .filter(entry -> entry.getKey().contains(name))
                .map(m -> m.getValue())
                .collect(Collectors.toList());
    }

    private class Contact {
        String name;
        String phone;
        public Contact(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}
