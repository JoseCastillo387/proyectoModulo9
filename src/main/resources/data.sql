INSERT INTO `categoria` (`id_categoria`, `descripcion`, `nombre`) VALUES
(1, 'Categoría de tecnología y gadgets', 'Tecnología'),
(2, 'Categoría de libros y literatura', 'Libros'),
(3, 'Categoría de ropa y accesorios', 'Moda'),
(4, 'Categoría de alimentos y bebidas', 'Alimentos'),
(5, 'Categoría de deportes y fitness', 'Deportes');

INSERT INTO `usuario` (`id_usuario`, `email`, `fecha_creacion`, `nombre_usuario`, `password`) VALUES
(1, 'usuario1@example.com', '2025-03-07 12:00:00.000000', 'UsuarioUno', 'password123'),
(2, 'usuario2@example.com', '2025-03-07 12:30:00.000000', 'UsuarioDos', 'securePass456'),
(3, 'usuario3@example.com', '2025-03-07 13:00:00.000000', 'UsuarioTres', 'hashpass789');

INSERT INTO `producto` (`id_producto`, `descripcion`, `fecha_creacion`, `imagen`, `nombre_producto`, `precio`, `stock`, `id_categoria`) VALUES
(1, 'Smartphone de última generación con cámara de 108MP', '2025-03-07 10:00:00.000000', 'smartphone.jpg', 'Smartphone Pro Max', 999.99, 50, 4),
(2, 'Laptop ultradelgada con procesador de última generación', '2025-03-07 10:30:00.000000', 'laptop.jpg', 'Laptop Ultrabook', 1299.99, 30, 4),
(3, 'Libro de ciencia ficción premiado internacionalmente', '2025-03-07 11:00:00.000000', 'libro.jpg', 'Libro: Mundo Futuro', 19.99, 100, 5),
(4, 'Chaqueta de cuero genuino para hombre', '2025-03-07 11:30:00.000000', 'chaqueta.jpg', 'Chaqueta de Cuero', 199.99, 20, 6),
(5, 'Pack de 12 botellas de agua mineral premium', '2025-03-07 12:00:00.000000', 'agua.jpg', 'Agua Mineral Premium', 9.99, 200, 7),
(6, 'Bicicleta de montaña profesional con suspensión avanzada', '2025-03-07 12:30:00.000000', 'bicicleta.jpg', 'Bicicleta de Montaña', 799.99, 15, 8);

INSERT INTO `pedido` (`id_pedido`, `fecha`, `total`, `id_usuario`) VALUES
(1, '2025-03-07 14:00:00.000000', 1299.99, 1),
(2, '2025-03-08 10:00:00.000000', 150, 2),
(3, '2025-03-09 15:30:00.000000', 999.99, 1),
(4, '2025-03-10 18:00:00.000000', 49.98, 3);
