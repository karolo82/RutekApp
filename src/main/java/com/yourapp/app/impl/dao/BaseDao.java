package com.yourapp.app.impl.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

/**
 * Bazowe Dao zawierające podtawowe operacje.
 */
public interface BaseDao<Key, Type> {
	/**
	 * Pobranie objektu po identyfikatorze.
	 * 
	 * @param id
	 *            Identyfikator objektu.
	 * @return Pobrany objekt.
	 */
	Type get(Key id);

	/**
	 * Pobranie listy obiektów o podanych identyfikatorach.
	 * 
	 * @param ids
	 *            Lista identyfikatorów obiektu.
	 * @return Lista obiektów.
	 */
	List<Type> get(Collection<Key> ids);

	/**
	 * Dodanie nowego obiektu.
	 * 
	 * @param type
	 *            Objekt do zapisania.
	 * @return Identyfikator zapisanego obiektu.
	 */
	long save(Type type);

	/**
	 * Zapisanie zmian w objekcie.
	 * 
	 * @param type
	 *            Obiekt do zapisania.
	 */
	void update(Type type);

	/**
	 * Usunięcie oiektu.
	 * 
	 * @param type
	 *            Obiekt do usunięcia.
	 */
	void delete(Type type);

	/**
	 * Usunięcie oiektu.
	 * 
	 * @param id
	 *            Identyfikator obiektu.
	 */
	void deleteById(Key id);

	public Session getCurrentSession();
}
