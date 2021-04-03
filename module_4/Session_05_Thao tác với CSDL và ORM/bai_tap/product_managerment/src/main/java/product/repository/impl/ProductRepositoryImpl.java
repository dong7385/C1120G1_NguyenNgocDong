package product.repository.impl;

import org.springframework.stereotype.Repository;
import product.model.Product;
import product.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.util.List;

@Transactional
@Repository
class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = em.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        if (product.getId() != 0) {
            em.merge(product);
        } else {
            em.persist(product);
        }
    }


    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = em.createQuery("select p from Product p where  p.id=:id", Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        if (product != null) {
            em.remove(product);
        }
    }
}
